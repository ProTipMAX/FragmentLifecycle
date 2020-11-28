package kz.meken.fragmentlifecycleexploring.some

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import kz.meken.fragmentlifecycleexploring.R
import org.koin.android.viewmodel.ext.android.viewModel

private const val TAG = "SomeFragment"

class SomeFragment : Fragment(R.layout.fragment_some) {

    private lateinit var counterTextView: TextView
    private lateinit var incrementButton: Button
    private lateinit var decrementButton: Button
    private val viewModel: SomeViewModel by viewModel()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG, "onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "onViewCreated")
        initViews(view)
        onSetButtonListeners()
        oSetObserver()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d(TAG, "onActivityCreated")
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

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG, "onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d(TAG, "onDetach")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(TAG, "onSaveInstanceState")
    }

    private fun initViews(view: View) {
        counterTextView = view.findViewById(R.id.fragment_some_text_view_counter)
        incrementButton = view.findViewById(R.id.fragment_some_button_increment)
        decrementButton = view.findViewById(R.id.fragment_some_button_decrement)
    }

    private fun onSetButtonListeners() {
        incrementButton.setOnClickListener {
            onIncrementButtonClick()
        }
        decrementButton.setOnClickListener {
            onDecrementButtonClick()
        }
    }

    private fun onIncrementButtonClick() {
        viewModel.incrementCounter()
    }

    private fun onDecrementButtonClick() {
        viewModel.decrementCounter()
    }

    private fun oSetObserver() {
        viewModel.counter.observe(viewLifecycleOwner, {
            counterTextView.text = it.toString()
        })
    }
}