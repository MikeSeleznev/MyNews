package com.example.mynews.common.navigation


import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.example.mynews.R
import com.example.mynews.common.di.scope.PerApplication
import com.example.mynews.news.view.NewsFragment
import javax.inject.Inject


@PerApplication
class NavigatorImpl
    @Inject constructor(): Navigator {

    private var fragment: Fragment? = null

    private var activity: AppCompatActivity? = null

    private val fragmentManager
        get() = activity?.supportFragmentManager


    private val currentFragment
        get() = fragmentManager?.findFragmentById(R.id.content)


    override fun attachActivity(activity: AppCompatActivity) {
        this.activity = activity
    }

    override fun detachActivity(activity: AppCompatActivity) {
        if (this.activity == activity) {
            this.activity = null
        }
    }


    private fun replaceFragment(fragment: Fragment) = runOnUiThread {
        fragmentManager?.let {
            it.beginTransaction()
                .replace(R.id.content, fragment)
                .addToBackStack(fragment::class.simpleName)
                .commit()}
        /*fragmentManager?.transaction {
            replace(R.id.content, fragment)
            if (addToBackStack) {
                addToBackStack(fragment::class.simpleName)
            }
        }*/
    }

    private inline fun runOnUiThread(crossinline action: () -> Unit) {
        activity?.runOnUiThread { action() }
    }




    override fun onStartMainActivity() {
        replaceFragment(NewsFragment.newInstance())
    }

    //override fun onBackPressed() = currentFragment is MarksFragment

    override fun onFinish(fragment: Fragment) {
        if (currentFragment == fragment) {
            fragmentManager?.popBackStack()
        }
    }

}