package br.com.claudio.appaulamvp.view

// Criando contrato entre as camadas
interface MainContract {
    // definir o contrato(metodos) da nossa View
    interface View {
        //Mostrar ProgressBar para o usuario
        fun showProgressBar()
        //Esconder ProgressBar
        fun hideProgressBar()
        //Mostrar o nome para o usuario
        fun showName(string: String?)
    }

    // definir o contrato(metodos) do nosso Model
    interface Model {
        interface OnFinishedListener {
            fun onFinished(string: String?)
        }
        fun getNextName(onFinishedListener: OnFinishedListener)
    }

    // definir o contrato(metodos) do nosso Presenter
    interface Presenter {
        fun onButtonClick()
    }
}