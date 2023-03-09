package esterella.cheeseit.presentation.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.CookieManager
import android.webkit.WebViewClient
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import esterella.cheeseit.databinding.FragmentWebViewBinding

class WebViewFragment : Fragment() {

    private var _binding: FragmentWebViewBinding? = null
    private val binding get() = _binding!!
    private var url: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parseArgs()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWebViewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setOnBackPressedDispatcher()
        openWebView(url.toString(), savedInstanceState)

    }

    private fun parseArgs() {
        val args = requireArguments()
        if (!args.containsKey(URL)) {
            throw RuntimeException("Param url is absent")
        }
        url = args.getString(URL)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        binding.mainWebView.saveState(outState)
        super.onSaveInstanceState(outState)
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun openWebView(url: String, savedInstanceState: Bundle?) {
        val cookieManager: CookieManager = CookieManager.getInstance()
        cookieManager.setAcceptCookie(true)
        binding.mainWebView.webViewClient = WebViewClient()

        binding.mainWebView.settings.apply {
            binding.mainWebView.settings.domStorageEnabled = true
            javaScriptCanOpenWindowsAutomatically = true
            javaScriptEnabled = true
            loadWithOverviewMode = true
            useWideViewPort = true
            databaseEnabled = true
            setSupportZoom(false)
            allowFileAccess = true
            allowContentAccess = true
        }
        if (savedInstanceState != null) binding.mainWebView.restoreState(savedInstanceState)
        else binding.mainWebView.loadUrl(url)
    }

    private fun setOnBackPressedDispatcher() {
        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (binding.mainWebView.canGoBack()) binding.mainWebView.goBack()
            }
        }
        activity?.onBackPressedDispatcher?.addCallback(viewLifecycleOwner, callback)
    }

    companion object {
        private const val URL = "url"

        fun newInstance(url: String): WebViewFragment {
            return WebViewFragment().apply {
                arguments = Bundle().apply {
                    putString(URL, url)
                }
            }
        }
    }
}