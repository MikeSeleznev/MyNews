package com.example.mynews.common.view

import com.example.mynews.common.presenter.BasePresenter

abstract class PresenterFragment<T : BasePresenter<*>> : InjectableFragment() {

    protected abstract val presenter: T

    override fun onPause() {
        super.onPause()
        if (requireActivity().isFinishing) {
            presenter.onFinish()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onFinish()
    }
}
