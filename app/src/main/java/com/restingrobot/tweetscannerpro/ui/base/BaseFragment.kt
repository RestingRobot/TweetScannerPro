package com.restingrobot.tweetscannerpro.ui.base

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import com.restingrobot.tweetscannerpro.R
import java.lang.ClassCastException

/**
 * A [Fragment] subclass that can be extended for all other fragments
 */
abstract class BaseFragment<VB: ViewBinding, VM : ViewModel> : Fragment() {

	private var _binding: VB? = null
	protected val binding get() = _binding!!

	lateinit var baseActivity: BaseActivity

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		_binding = getViewBinding(inflater, container)
		return binding.root
	}

	override fun onAttach(context: Context) {
		super.onAttach(context)

		try {
			activity?.let {
				if(it is BaseActivity) {
					baseActivity = activity as BaseActivity
				}
			}
		} catch(e: ClassCastException) {
			throw ClassCastException("$context must be BaseActivity")
		}
	}

	override fun onDestroy() {
		super.onDestroy()
		_binding = null
	}

	protected abstract fun getViewBinding(inflater: LayoutInflater, container: ViewGroup?): VB

	fun applicationContext(): Context = requireActivity().applicationContext

	fun toast(message: String) {
		Toast.makeText(activity, message, Toast.LENGTH_LONG).show()
	}



}
