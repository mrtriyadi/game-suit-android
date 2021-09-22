package com.renditriyadi.gamesuitchallenge

import android.graphics.Color
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private val playerGunting: ImageView by lazy {
        findViewById(R.id.img_gunting_player)
    }
    private val playerBatu: ImageView by lazy {
        findViewById(R.id.img_batu_player)
    }
    private val playerKertas: ImageView by lazy {
        findViewById(R.id.img_kertas_player)
    }
    private val comGunting: ImageView by lazy {
        findViewById(R.id.img_gunting_com)
    }
    private val comBatu: ImageView by lazy {
        findViewById(R.id.img_batu_com)
    }
    private val comKertas: ImageView by lazy {
        findViewById(R.id.img_kertas_com)
    }
    private val labelPemenang: TextView by lazy {
        findViewById(R.id.labelpemenang)
    }
    private val refresh:ImageView by lazy{
        findViewById(R.id.img_refresh)
    }

    private val labelSkorPemain:TextView by lazy{
        findViewById(R.id.labelskorpemain)
    }

    private val labelSkorCom:TextView by lazy{
        findViewById(R.id.labelskorcom)
    }

    private var playerNilai:String=""

    private var nilai = arrayListOf("GUNTING","BATU","KERTAS")
    private var computerNilai:String=""
    private var hasil:String=""
    private var skorAnda:Int=0
    private var skorCom:Int=0

    fun cekPemenang(nilaiPemain:String):Unit{
        computerNilai=nilai.random()
        when(computerNilai){
            "GUNTING"->{
                comGunting.rotation=30F
                comGunting.setBackgroundColor(Color.RED)
            }
            "BATU"->{
                comBatu.rotation=30F
                comBatu.setBackgroundColor(Color.RED)
            }
            "KERTAS"->{
                comKertas.rotation=30F
                comKertas.setBackgroundColor(Color.RED)
            }
        }
        when(nilaiPemain){
            "GUNTING"-> {
                when (computerNilai) {
                    "GUNTING" -> hasil = "SERI"
                    "KERTAS" -> hasil = "ANDA MENANG"
                    "BATU" -> hasil = "COMPUTER MENANG"
                }
            }
            "KERTAS" ->{
                when(computerNilai){
                    "GUNTING"-> hasil="COMPUTER MENANG"
                    "KERTAS" -> hasil="SERI"
                    "BATU" -> hasil="ANDA MENANG"
                }
            }
            "BATU"->{
                when(computerNilai){
                    "GUNTING"-> hasil="ANDA MENANG"
                    "KERTAS" -> hasil="COMPUTER MENANG"
                    "BATU" -> hasil="SERI"
                }
            }
        }
        labelPemenang.text=hasil
        when(hasil){
            "COMPUTER MENANG" -> {
                labelPemenang.setTextColor(Color.RED)
                skorCom++
                labelSkorCom.text="Skor "+skorCom
            }
            "ANDA MENANG"-> {
                labelPemenang.setTextColor(Color.BLUE)
                skorAnda++
                labelSkorPemain.text="Skor "+skorAnda
            }
            "SERI"-> labelPemenang.setTextColor(Color.RED)
        }
    }

    fun clear():Unit{
        playerKertas.rotation=360f
        playerKertas.setBackgroundColor(Color.TRANSPARENT)
        playerBatu.rotation=360f
        playerBatu.setBackgroundColor(Color.TRANSPARENT)
        playerGunting.rotation=360f
        playerGunting.setBackgroundColor(Color.TRANSPARENT)
        comKertas.rotation=360f
        comKertas.setBackgroundColor(Color.TRANSPARENT)
        comGunting.rotation=360f
        comGunting.setBackgroundColor(Color.TRANSPARENT)
        comBatu.rotation=360f
        comBatu.setBackgroundColor(Color.TRANSPARENT)
        labelPemenang.text=""

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        playerGunting.setOnClickListener(){
            clear()
            playerGunting.rotation= 30F
            playerGunting.setBackgroundColor(Color.BLUE)
            playerNilai="GUNTING"
            cekPemenang(playerNilai)
        }

        playerBatu.setOnClickListener(){
            clear()
            playerBatu.rotation= 30F
            playerBatu.setBackgroundColor(Color.BLUE)
            playerNilai="BATU"
            cekPemenang(playerNilai)
        }

        playerKertas.setOnClickListener(){
            clear()
            playerKertas.rotation= 30F
            playerKertas.setBackgroundColor(Color.BLUE)
            playerNilai="KERTAS"
            cekPemenang(playerNilai)
        }

        refresh.setOnClickListener(){
            clear()
            labelSkorCom.text="Skor 0"
            labelSkorPemain.text="Skor 0"
        }
    }
}