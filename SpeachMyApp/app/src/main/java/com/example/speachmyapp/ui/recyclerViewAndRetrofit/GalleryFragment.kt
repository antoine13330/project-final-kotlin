package com.example.speachmyapp.ui.recyclerViewAndRetrofit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.speachmyapp.databinding.FragmentGalleryBinding
import com.example.speachmyapp.ui.network.API
import com.example.speachmyapp.ui.network.RetrofitBuilder
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Response

class GalleryFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null


    /*region class var*/
    private val binding get() = _binding!!
    private lateinit var retrofitBuilder : RetrofitBuilder
    private lateinit var apiService : API;
    private lateinit var cardList : ArrayList<CatFact>
    private lateinit var cardAdapter: CardAdapter;
    /*endregion class var*/
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root
        /*#region network */
        retrofitBuilder = RetrofitBuilder()
        apiService =  retrofitBuilder.buildService(API::class.java)
        /*#endregion network */
        /*#region recycler */
        cardList = ArrayList()
        cardAdapter = CardAdapter(requireContext(),cardList)

        binding.compRecyclerView.layoutManager = GridLayoutManager(requireContext(),1)
        binding.compRecyclerView.adapter = cardAdapter

        binding.compButtonAddCatFact.setOnClickListener{
            GlobalScope.launch {
                cardList.add(loadCatFact())
            }
            cardAdapter.notifyItemInserted(cardList.size-1)
        }
        /*#endregion recycler*/
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    private suspend fun loadCatFact() :  CatFact {
        var requestNewCatFact : Response<CatFact> = apiService.getFact()
        var answer: CatFact = requestNewCatFact.body()!!
        return answer
    }
}

