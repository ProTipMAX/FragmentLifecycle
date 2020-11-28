package kz.meken.fragmentlifecycleexploring.some

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log

import androidx.appcompat.app.AppCompatActivity
import kz.meken.fragmentlifecycleexploring.R

private const val TAG = "MainActivity"

class SomeActivity : AppCompatActivity() {

    private val container: Int = R.id.activity_some_frame_layout_container
    private lateinit var someFragment: SomeFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_some)

        initViews()
        setSomeFragment()
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(TAG, "onSaveInstanceState")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d(TAG, "onRestoreInstanceState")
    }

    private fun initViews() {
        someFragment = SomeFragment()
    }

    private fun setSomeFragment() {
        supportFragmentManager.beginTransaction()
            .replace(container, someFragment)
            .commit()
    }
}