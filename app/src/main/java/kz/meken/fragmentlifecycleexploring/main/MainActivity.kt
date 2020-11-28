package kz.meken.fragmentlifecycleexploring.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import kz.meken.fragmentlifecycleexploring.R
import kz.meken.fragmentlifecycleexploring.main.fragments.FirstFragment
import kz.meken.fragmentlifecycleexploring.main.fragments.SecondFragment
import kz.meken.fragmentlifecycleexploring.main.fragments.ThirdFragment

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

        if (savedInstanceState != null) {
            val name = savedInstanceState.getString("temp_key")
            Toast.makeText(this, name, Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Empty Bundle", Toast.LENGTH_SHORT).show()
        }

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

//    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
//        super.onSaveInstanceState(outState, outPersistentState)
//        Log.d(TAG, "onSaveInstanceState")
//        outState.putString("temp_key", "Meken")
//    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(TAG, "onSaveInstanceState")
        outState.putString("temp_key", "Meken")
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
        displayFragment(mFirstFragment, FirstFragment.TAG)
    }

    private fun initBottomNavigationViewListener() {
        bnv.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.activity_main_bnv_first -> {
                    displayFragment(mFirstFragment, FirstFragment.TAG)
                    true
                }
                R.id.activity_main_bnv_second -> {
                    displayFragment(mSecondFragment, SecondFragment.TAG)
                    true
                }
                R.id.activity_main_bnv_third -> {
                    displayFragment(mThirdFragment, ThirdFragment.TAG)
                    true
                }
                else -> false
            }
        }
    }

    private fun displayFragment(
        fragment: Fragment,
        tag: String
    ) {
        fragmentManager.beginTransaction()
            .replace(containerId, fragment)
            .commit()

//        val foundFragment = fragmentManager.findFragmentByTag(tag)
//
//        if (foundFragment == null) {
//            fragmentManager.beginTransaction()
//                .hide(mActiveFragment)
//                .add(containerId, fragment, tag)
//                .commit()
//        } else {
//            fragmentManager.beginTransaction()
//                .hide(mActiveFragment)
//                .show(foundFragment)
//                .commit()
//        }
        mActiveFragment = fragment
    }
}