package br.com.carloscarvalho.calculaflex

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.carloscarvalho.calculaflex.extensions.format
import kotlinx.android.synthetic.main.activity_form.*
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        calculate()
    }

    private fun calculate(){
        val gasPrice = intent.extras.getDouble("GAS_PRICE", 0.0)
        val etanolPrice = intent.extras.getDouble("ETANOL_PRICE", 0.0)
        val gasAverage = intent.extras.getDouble("GAS_AVERAGE", 0.0)
        val etanolAverage = intent.extras.getDouble("ETANOL_AVERAGE", 0.0)

        val performanceMyCar = etanolAverage / gasAverage
        val priceOfIndice = etanolPrice / gasPrice

        if( priceOfIndice <= performanceMyCar ){
            tvSuggestion.text = getString(R.string.ethanol)
        }else{
            tvSuggestion.text = getString(R.string.gasoline)
        }

        tvEthanolAverageResult.text = (etanolPrice / etanolAverage).format(2)
        tvGasAverageResult.text = (gasPrice / gasAverage).format(2)

    }
}
