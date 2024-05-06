package br.com.claudio.appaulamvp.presenter

import br.com.claudio.appaulamvp.view.MainContract

class MainPresenter(
    private var mainView: MainContract.View,
    private var model: MainContract.Model
) : MainContract.Presenter, MainContract.Model.OnFinishedListener {

    //Recebeu acao do click do usuario
    override fun onButtonClick() {
        mainView.showProgressBar()
        model.getNextName(this)
    }

    override fun onFinished(string: String?) {
        mainView.hideProgressBar()
        mainView.showName(string)
    }
}