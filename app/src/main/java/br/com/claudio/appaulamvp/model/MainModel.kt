package br.com.claudio.appaulamvp.model

import android.os.Handler
import android.os.Looper
import br.com.claudio.appaulamvp.view.MainContract
import java.util.Arrays
import java.util.Random

class MainModel : MainContract.Model {

    //Fonte de dados de nomes
    private val namesList = Arrays.asList(
        "Anderson",
        "Allan",
        "Bruno",
        "Breno",
    )

    override fun getNextName(onFinishedListener: MainContract.Model.OnFinishedListener) {
        Handler(Looper.getMainLooper()).postDelayed({
            onFinishedListener.onFinished(getRandomString)
        }, 1200)
    }

    private val getRandomString: String
        get() {
            val random = Random()
            val index = random.nextInt(namesList.size)
            return namesList[index]
        }
}