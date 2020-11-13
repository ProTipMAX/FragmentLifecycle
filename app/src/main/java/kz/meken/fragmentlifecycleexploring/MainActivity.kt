package kz.meken.fragmentlifecycleexploring

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import kz.meken.fragmentlifecycleexploring.fragments.FirstFragment
import kz.meken.fragmentlifecycleexploring.fragments.SecondFragment
import kz.meken.fragmentlifecycleexploring.fragments.ThirdFragment

const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    private lateinit var fragmentManager: FragmentManager
    private lateinit var mActiveFragment: Fragment
    private lateinit var mFirstFragment: Fragment
    private lateinit var mSecondFragment: Fragment
    private lateinit var mThirdFragment: Fragment
    private lateinit var bnv: BottomNavigationView

    private val containerId: Int = R.id.activity_main_frame_layout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        setInitialFragment()
        initBottomNavigationViewListener()
        Log.d(TAG, "onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart")
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

    private fun initViews() {
        fragmentManager = supportFragmentManager
        mFirstFragment = FirstFragment()
        mSecondFragment = SecondFragment()
        mThirdFragment = ThirdFragment()
        bnv = findViewById(R.id.activity_main_bottom_navigation_view)
    }

    private fun setInitialFragment() {
        mActiveFragment = FirstFragment()
    }

    private fun initBottomNavigationViewListener() {
        bnv.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.activity_main_bnv_first -> {
                    displayFragment(mFirstFragment)
                    true
                }
                R.id.activity_main_bnv_second -> {
                    displayFragment(mSecondFragment)
                    true
                }
                R.id.activity_main_bnv_third -> {
                    displayFragment(mThirdFragment)
                    true
                }
                else -> false
            }
        }
    }

    private fun displayFragment(
        fragment: Fragment
    ) {
        fragmentManager.beginTransaction()
            .replace(containerId, fragment)
            .commit()

        mActiveFragment = fragment
    }
}