package br.com.claudio.appaulamvp.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import br.com.claudio.appaulamvp.databinding.ActivityMainBinding
import br.com.claudio.appaulamvp.model.MainModel
import br.com.claudio.appaulamvp.presenter.MainPresenter

class MainActivity : AppCompatActivity(), MainContract.View {
    private lateinit var binding: ActivityMainBinding
    private lateinit var presenter: MainPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = MainPresenter(this, MainModel())

        binding.btGenerate.setOnClickListener {
            presenter.onButtonClick()
        }
    }

    override fun showProgressBar() {
        binding.progressBar.visibility = View.VISIBLE
        binding.tvName.visibility = View.INVISIBLE
    }

    override fun hideProgressBar() {
        binding.progressBar.visibility = View.INVISIBLE
        binding.tvName.visibility = View.VISIBLE
    }

    override fun showName(string: String?) {
        binding.tvName.text = string
    }
}