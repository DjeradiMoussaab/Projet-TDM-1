package com.example.projet1

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.*
import android.widget.Button
import android.widget.PopupMenu
import com.example.projet1.adapters.ActualiteAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_actualite.*
import com.example.projet1.Models.Thematique
import kotlinx.android.synthetic.main.fragment_actualite_item.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [Actualite.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [Actualite.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class Actualite : Fragment(), PopupMenu.OnMenuItemClickListener {

    override fun onMenuItemClick(p0: MenuItem?): Boolean {
        return true
    }

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null
    private var recylclerview = activity?.findViewById<RecyclerView>(R.id.actualites_recycler_view)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_actualite, container, false)

        view.findViewById<Button>(R.id.filter_btn).setOnClickListener {
            var menu = PopupMenu(context, view.findViewById(R.id.filter_btn))
            var i = 0
            for ( theme in Data.ThematiqueList ) {
                menu.menu.add(Menu.NONE,i,i,theme.title)
                i++
            }
            menu.setOnMenuItemClickListener(this)
            menu.inflate(R.menu.thematiquemenu)
            menu.setOnMenuItemClickListener(object : PopupMenu.OnMenuItemClickListener {

                override fun onMenuItemClick(item: MenuItem): Boolean {
                    updateActualites(item.title.toString())
                    return true
                }
            })
            menu.show()

        }



        return view
    }


    fun updateActualites(theme : String) {
        Data.initData()
        var newActauliteList = ArrayList<com.example.projet1.Models.Actualite>()
        for ( actualite in Data.ActualiteList ) {
            if ( actualite.theme.title == theme ) {
                newActauliteList.add(actualite)
            }
        }
        actualites_recycler_view.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = ActualiteAdapter(newActauliteList)
        }

    }

    override fun onResume() {
        val l=listener
        l?.let {
            Data.initData()
            val adapter = ActualiteAdapter(Data.ActualiteList)
            recylclerview?.adapter = adapter
        }
        super.onResume()
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        actualites_recycler_view.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = ActualiteAdapter(Data.ActualiteList)
        }

    }


    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
//            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Actualite.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Actualite().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }

    }

}






