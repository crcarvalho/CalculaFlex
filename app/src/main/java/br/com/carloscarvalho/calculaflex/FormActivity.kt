package br.com.carloscarvalho.calculaflex

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.carloscarvalho.calculaflex.extensions.getValue
import br.com.carloscarvalho.calculaflex.watchers.DecimalTextWatcher
import kotlinx.android.synthetic.main.activity_form.*

class FormActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        etGasPrice.addTextChangedListener(DecimalTextWatcher(etGasPrice))
        etEthanolPrice.addTextChangedListener(DecimalTextWatcher(etEthanolPrice))

        etGasAverage.addTextChangedListener(DecimalTextWatcher(etGasAverage, 1))
        etEthanolAverage.addTextChangedListener(DecimalTextWatcher(etEthanolAverage, 1))

        btCalculate.setOnClickListener {
            val proximaTela = Intent(this, ResultActivity::class.java)
            proximaTela.putExtra("GAS_PRICE", etGasPrice.getValue())
            proximaTela.putExtra("ETANOL_PRICE", etEthanolPrice.getValue())
            proximaTela.putExtra("GAS_AVERAGE", etGasAverage.getValue())
            proximaTela.putExtra("ETANOL_AVERAGE", etEthanolAverage.getValue())

            startActivity(proximaTela)
        }

    }
}
