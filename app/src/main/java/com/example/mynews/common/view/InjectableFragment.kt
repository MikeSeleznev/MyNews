package com.example.mynews.common.view

import com.example.mynews.common.di.injector.Injector
import com.example.mynews.common.di.injector.InjectorProvider


abstract class InjectableFragment : BaseFragment() {

    protected val injector: Injector
        get() = (requireContext().applicationContext as InjectorProvider).injector
}
