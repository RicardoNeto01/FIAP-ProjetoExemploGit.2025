package com.RicardoNeto01.geradordesenhas

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.RicardoNeto01.geradordesenhas.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding .inflate(layoutInflater)
        setContentView( binding.root)

        val length = intent.getIntExtra(EXTRA_TAMANHO_SENHA, 0)
        val senha = gerarSenha(length)
        binding.tvSenha.text = "Senha gerada:\n$senha"

    }
    private fun gerarSenha(tamanho: Int): String {
        val chars =
            "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#\$%&*"
        return (1..tamanho).map { chars.random() }.joinToString("")
    }
    companion object{
        const val EXTRA_TAMANHO_SENHA = "EXTRA_TAMANHO_SENHA"
    }
}


