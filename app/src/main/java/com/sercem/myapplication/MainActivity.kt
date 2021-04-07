package com.sercem.tahminoyunu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.sercem.tahminoyunu.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sayi = Random.nextInt(1,100)
        var skor = 100

        responseTextView.findViewById<TextView>(R.id.responseTextView)
        skorTextView.findViewById<TextView>(R.id.skorTextView)

        skorTextView.text = "Skorunuz: ${skor}"
        tahminEtButton.setOnClickListener {
            var tahmin = binding.tahminEditText.text.toString().toInt()

                if(tahmin < sayi){
                    skor --
                    responseTextView.text = "Daha Büyük Bir Sayı Dene"
                    skorTextView.text = "Skorunuz: ${skor}"

                } else if (tahmin > sayi) {
                    skor --
                    responseTextView.text = "Daha Küçük Bir Sayı Dene"
                    skorTextView.text = "Skorunuz: ${skor}"

                } else if(tahmin == sayi) {
                    responseTextView.text = "Tebrikler Bildiniz! Skorunuz: ${skor} "
                    skorTextView.text = null
                    tahminEditText.setReadOnly(true)

            }

        }
    }
    fun EditText.setReadOnly(value: Boolean, inputType: Int = InputType.TYPE_NULL) {
        isFocusable = !value
        isFocusableInTouchMode = !value
        this.inputType = inputType
    }
}