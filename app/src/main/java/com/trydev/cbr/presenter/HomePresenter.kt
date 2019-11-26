package com.trydev.cbr.presenter

import android.content.Context
import android.util.Log
import com.trydev.cbr.contract.HomeContract
import com.trydev.cbr.model.History
import com.trydev.cbr.model.Indication
import com.trydev.cbr.model.IndicationSimilarityValue
import com.trydev.cbr.model.Similarity
import java.text.DecimalFormat

class HomePresenter : HomeContract.Presenter{
    private var listHistory: ArrayList<History>
    private var listIndication : ArrayList<Indication>
    private var view : HomeContract.View
    private var decimalFormat : DecimalFormat
    private var decimalFormat2 : DecimalFormat

    constructor(
        view: HomeContract.View
    ) {
        this.view = view
        listIndication = ArrayList<Indication>()
        decimalFormat = DecimalFormat("#.###")
        decimalFormat2 = DecimalFormat("#.##")

        var list : ArrayList<History>
        list = ArrayList()

        var indication1 : ArrayList<Indication> = ArrayList()
        indication1.add(
            Indication(2, "Sesak Nafas", 0.6)
        )
        indication1.add(
            Indication(8, "Kelainan Bunyi Jatung", 0.2)
        )
        indication1.add(
            Indication(3, "Keringat Dingin", 0.5)
        )

        var indication2 : ArrayList<Indication> = ArrayList()
        indication2.add(
            Indication(2, "Sesak Nafas", 0.6)
        )
        indication2.add(
            Indication(5, "Mudah Lelah", 0.6)
        )

        var indication3 : ArrayList<Indication> = ArrayList()
        indication3.add(
            Indication(6, "Batuk Kering", 0.2)
        )
        indication3.add(
            Indication(7, "Sakit Leher/Punggung", 0.4)
        )
        indication3.add(
            Indication(4, "Pembengkakan Kaki", 0.7)
        )

        var indication4 : ArrayList<Indication> = ArrayList()
        indication4.add(
            Indication(3, "Keringat Dingin", 0.5)
        )
        indication4.add(
            Indication(1, "Nyeri Dada", 0.7)
        )
        indication4.add(
            Indication(8, "Kelainan Bunyi Jatung", 0.2)
        )

        var indication5 : ArrayList<Indication> = ArrayList()
        indication5.add(
            Indication(8, "Kelainan Bunyi Jatung", 0.2)
        )
        indication5.add(
            Indication(4, "Pembengkakan Kaki", 0.7)
        )
        indication5.add(
            Indication(3, "Keringat Dingin", 0.5)
        )
        indication5.add(
            Indication(5, "Mudah Lelah", 0.6)
        )

        list.add(
            History(
                1,
                "Serangan Jantung",
                indication1
            )
        )
        list.add(
            History(
                2,
                "Gagal Jantung",
                indication2
            )
        )
        list.add(
            History(
                3,
                "Gagal Jantung",
                indication3
            )
        )
        list.add(
            History(
                4,
                "Gagal Jantung",
                indication4
            )
        )
        list.add(
            History(
                5,
                "Serangan Jantung",
                indication5
            )
        )

        listHistory = list
    }

    override fun setIndication(indication: Indication) {
        var cek : Boolean = false
        for (i in listIndication) {
            if (i.code == indication.code){
                cek = true
            }
        }
        if (!cek){
            listIndication.add(indication)
        }
    }

    override fun removeIndication(indication: Indication) {
        var cek : Boolean = false
        for (i in listIndication) {
            if (i.code == indication.code){
                cek = true
            }
        }
        if (cek){
            listIndication.remove(indication)
        }
    }

    override fun find() {
        if (listIndication.size > 0){
            var similarity : ArrayList<Similarity> = ArrayList()
            for (h in listHistory){
                var iistIndicationSimilarityValue : ArrayList<IndicationSimilarityValue> = ArrayList()

                var sumWpTop : Double = 0.0
                var sumWpBottom : Double = 0.0
                var jst : Int = 0

                for (hi in h.listIndication){
                    var cek : Boolean = false
                    for (i in listIndication){
                        if (hi.code == i.code){
                            cek = true
                            sumWpTop = sumWpTop + decimalFormat.format(Math.pow(hi.value, 3.0)).toDouble()
                            jst++
                            break
                        }
                    }
                    sumWpBottom = sumWpBottom + decimalFormat.format(Math.pow(hi.value, 3.0)).toDouble()
                    iistIndicationSimilarityValue.add(IndicationSimilarityValue(hi, cek))
                }
                var result: Double = (Math.cbrt(decimalFormat2.format(sumWpTop/sumWpBottom).toDouble()) * decimalFormat2.format(jst * 100 / 8).toDouble()) / 100
                similarity.add(Similarity(h, iistIndicationSimilarityValue, result))
//                Log.e("wpTop", sumWpTop.toString())
//                Log.e("wpBottom", sumWpBottom.toString())
//                Log.e("bagiTopBottom", (sumWpTop/sumWpBottom).toString())
//                Log.e("akar 3", ( Math.cbrt( decimalFormat2.format(sumWpTop/sumWpBottom).toDouble()) ).toString())
//                printListSimilarity(similarity)
            }
            var maxSimilarity: Similarity = similarity.get(0)
            for (s in similarity){
                if (maxSimilarity.result < s.result){
                    maxSimilarity = s
                }
            }
            var str = ""
            for (i in maxSimilarity.history.listIndication) {
                str += i.name + ", "
            }
            str.removeRange(str.length-2, str.length)
            str = "Kasus anda mirip dengan kasus C" + maxSimilarity.history.code.toString() +"("+str+ ") yang bernilai " + decimalFormat2.format(maxSimilarity.result * 100).toString() + "%"
            view.result(maxSimilarity.history.solution, str)
        } else {
            view.onError("Harus memilih gejala yang dialami")
        }
    }

    override fun attachView(mRootView: HomeContract.View, context: Context) {

    }

    override fun detachView() {

    }

    fun printListIndication(){
        for (i in listIndication){
            Log.e(i.code.toString(), i.name)
        }
    }

    fun printListSimilarity(list : ArrayList<Similarity>){
        for (l in list){
            Log.e(l.history.code.toString(), l.history.solution)
            for (s in l.listIndicationSimilarityValue){
                Log.e("G" + s.indication.code.toString(), s.total.toString())
            }
            Log.e("result", l.result.toString())
            Log.e("-------", "------------------------------------------")
        }
    }

}