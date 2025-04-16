package com.RicardoNeto01.geradordesenhas

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.widget.SeekBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.RicardoNeto01.geradordesenhas.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    private var tamanho = 8
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding .inflate(layoutInflater)
        setContentView( binding.root)

        binding.seekBar.setOnSeekBarChangeListener( object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged (seekBar: SeekBar?,
                                            progress: Int, fromUser: Boolean) {
                tamanho = progress. coerceAtLeast(4)
                binding.tvTamanho.text = "Tamanho da senha: $tamanho"
            }
            override fun onStartTrackingTouch (seekBar: SeekBar?) {}
            override fun onStopTrackingTouch (seekBar: SeekBar?) {}
        })
        binding.btnConfirmar .setOnClickListener {
            val nextScreen = Intent(this, ThirdActivity::class.java).apply {
                putExtra(ThirdActivity.EXTRA_TAMANHO_SENHA, tamanho)
            }

            val options = ActivityOptions.makeCustomAnimation(
                this,
                R.anim.slide_in_right,
                R.anim.slide_out_left
            )
            startActivity(nextScreen, options.toBundle())
        }

    }
}
