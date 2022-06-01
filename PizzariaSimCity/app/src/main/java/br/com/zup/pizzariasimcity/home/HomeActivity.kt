package br.com.zup.pizzariasimcity.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.zup.pizzariasimcity.FragmentoClick
import br.com.zup.pizzariasimcity.R
import br.com.zup.pizzariasimcity.databinding.ActivityHomeBinding
import br.com.zup.pizzariasimcity.fragments.DetalheFragment
import br.com.zup.pizzariasimcity.fragments.ProdutoFragment

class HomeActivity : AppCompatActivity(), FragmentoClick {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /**
         * Inicia o processo de exibir o fragmento
         */
        supportFragmentManager
            .beginTransaction()
            .add(binding.container.id, ProdutoFragment())
            .commit()
    }

    override fun clickFragmento(mensagem: String) {
        val fragmentoDetalhe = DetalheFragment().apply {
            arguments = Bundle().apply {
                putString("TEXTO", mensagem)
            }
        }

        supportFragmentManager
            .beginTransaction()
            .add(binding.container.id, fragmentoDetalhe)
            .addToBackStack("Detalhe")
            .commit()
    }
}