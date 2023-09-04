package com.badayproduction.lockersample

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.GridLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.badayproduction.lockersample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    lateinit var gridLayout:GridLayout
    lateinit var error:Drawable
    lateinit var success:Drawable
    lateinit var neutral:Drawable
    var sayac:Int = -1
    lateinit var pass1:TextView
    lateinit var pass2:TextView
    lateinit var pass3:TextView
    lateinit var pass4:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pass1 = binding.pass1
        pass2 = binding.pass2
        pass3 = binding.pass3
        pass4 = binding.pass4
        gridLayout = binding.gridLayout
        error = ContextCompat.getDrawable(this, R.drawable.red)!!
        success = ContextCompat.getDrawable(this, R.drawable.green)!!
        neutral = ContextCompat.getDrawable(this, R.drawable.circlebutton)!!

        val pass = "2023"

        binding.number0.setOnClickListener {
            sayacArttir(0)
        }
        binding.number1.setOnClickListener {
            sayacArttir(1)
        }
        binding.number2.setOnClickListener {
            sayacArttir(2)
        }
        binding.number3.setOnClickListener {
            sayacArttir(3)
        }
        binding.number4.setOnClickListener {
            sayacArttir(4)
        }
        binding.number5.setOnClickListener {
            sayacArttir(5)
        }
        binding.number6.setOnClickListener {
            sayacArttir(6)
        }
        binding.number7.setOnClickListener {
            sayacArttir(7)
        }
        binding.number8.setOnClickListener {
            sayacArttir(8)
        }
        binding.number9.setOnClickListener {
            sayacArttir(9)
        }

        binding.delete.setOnClickListener {
            pass1.text = ""
            pass2.text = ""
            pass3.text = ""
            pass4.text = ""
            sayac = -1
            for (i in 0 until gridLayout.childCount) {
                val childView = gridLayout.getChildAt(i)

              
                if (childView is TextView) {
                    childView.background = neutral 
                }
            }
        }
        binding.enter.setOnClickListener {

            if (pass1.text.toString()+pass2.text.toString()+pass3.text.toString()+pass4.text.toString()==pass){
                Toast.makeText(this, "Şifre Girildi", Toast.LENGTH_SHORT).show()
                for (i in 0 until gridLayout.childCount) {
                    val childView = gridLayout.getChildAt(i)

                   
                    if (childView is TextView) {
                        childView.background = success 
                    }
                }
            }else{
                for (i in 0 until gridLayout.childCount) {
                    val childView = gridLayout.getChildAt(i)

                    
                    if (childView is TextView) {
                        childView.background = error 
                    }
                }
                Toast.makeText(this, "Yanlış Şifre", Toast.LENGTH_SHORT).show()
            }
        }

    }
    fun sayacArttir(sayi: Int){
        sayac++
        if (sayac>=4){
            sayac=0
            pass2.text = ""
            pass3.text = ""
            pass4.text = ""
            for (i in 0 until gridLayout.childCount) {
                val childView = gridLayout.getChildAt(i)


                if (childView is TextView) {
                    childView.background = neutral 
                }
            }
        }
        if (sayac==0){
            pass1.text = sayi.toString()
        }else if (sayac==1){
            pass2.text=sayi.toString()
        }else if (sayac==2){
            pass3.text=sayi.toString()
        }else if (sayac==3)
            pass4.text=sayi.toString()
    }

}