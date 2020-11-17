package br.com.gastodeviagem

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        val id = view.id

        if (id == R.id.buttonCalculate) {
            calculate()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun calculate() {

        if (validationOK()) {
            val distance = edDistancia.text.toString().toFloat()
            val price = edPreco.text.toString().toFloat()
            val autonomy = edPrecoLitro.text.toString().toFloat()

            val totalValue = (distance * price) / autonomy
            textTotalValue.text = "R$ ${"%.2f".format(totalValue)}"
        }else{
            Toast.makeText(this, "Todos os campos são obrigatórios", Toast.LENGTH_SHORT).show()
        }

    }

    private fun validationOK(): Boolean {

        if(edDistancia.text.toString() == "")return false
        if(edPreco.text.toString() == "")return false
        if(edPrecoLitro.text.toString() == "")return false

        return true
    }
}