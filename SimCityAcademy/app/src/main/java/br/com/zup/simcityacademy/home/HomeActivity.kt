package br.com.zup.simcityacademy.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import br.com.zup.simcityacademy.R
import br.com.zup.simcityacademy.databinding.ActivityHomeBinding
import br.com.zup.simcityacademy.informacao.InformacaoActivity

class HomeActivity : AppCompatActivity() {
    private lateinit var editTextNomeAlune: EditText
    private val editTextNotaUm: EditText by lazy { findViewById(R.id.etNotaUm) }
    private val editTextNotaDois: EditText by lazy { findViewById(R.id.etNotaDois) }
    private var btnCalcularMédia: Button? = null

    /**
     * Declaração do viewBinding no projeto
     */
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /**
         * Inicialização da variavel binding
         */
        binding = ActivityHomeBinding.inflate(layoutInflater)
        /**
         * Adicionando o binding.root para o método que seta o layout que será exibido ao usuário
         */
        setContentView(binding.root)

        initViews()

        /**
         * Exemplo de uso do binding pelo id da view
         */
        binding.etNotaTres


        btnCalcularMédia?.setOnClickListener {
            enviarDadosAlune()
        }
    }

    private fun initViews() {
        editTextNomeAlune = findViewById(R.id.etNomeAlune)
        btnCalcularMédia = findViewById(R.id.btnCalcularMedia)
    }

    private fun enviarDadosAlune() {
        val nomeAlune = binding.etNomeAlune?.text
        val primeiraNota = binding.etNotaUm?.text
        val segundaNota = binding.etNotaDois?.text
        val terceiraNota = binding.etNotaTres?.text
        val quartaNota = binding.etNotaQuatro?.text

        val intent = Intent(this, InformacaoActivity::class.java).apply {
           putExtra("NOME_ALUNE", nomeAlune)
            putExtra("NOTA_UM", primeiraNota)
            putExtra("NOTA_DOIS", segundaNota)
            putExtra("NOTA_TRES", terceiraNota)
            putExtra("NOTA_QUATRO", quartaNota)
        }

        startActivity(intent)
    }
}