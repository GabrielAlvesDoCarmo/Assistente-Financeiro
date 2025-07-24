package br.com.gds.assistentefinanceiro.ui.base

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

abstract class BaseActivity<VM: ViewModel, DB: ViewDataBinding> : AppCompatActivity() {
    protected lateinit var viewModel: VM
        private set

    protected lateinit var binding: DB
        private set

    @LayoutRes
    abstract fun getLayoutId(): Int

    abstract fun getViewModelClass(): Class<VM>

    open fun setupBinding(binding: DB){
        binding.lifecycleOwner = this
    }

    open fun init(){}
    open fun setupObservers(){}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = DataBindingUtil.setContentView(this, getLayoutId())
        setupBinding(binding)
        viewModel = ViewModelProvider(this)[getViewModelClass()]
        init()
        setupObservers()

    }
}