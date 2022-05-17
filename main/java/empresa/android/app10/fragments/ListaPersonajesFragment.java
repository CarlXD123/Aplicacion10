package empresa.android.app10.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import empresa.android.app10.R;
import empresa.android.app10.adapters.PersonajesAdapter;
import empresa.android.app10.clases.PersonajeVo;



public class ListaPersonajesFragment extends Fragment implements SearchView.OnQueryTextListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    RecyclerView recyclerPersonajes;
    ArrayList<PersonajeVo> listaPersonaje;

    public ListaPersonajesFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static ListaPersonajesFragment newInstance(String param1, String param2) {
        ListaPersonajesFragment fragment = new ListaPersonajesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        initListener();


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista=inflater.inflate(R.layout.fragment_lista_personajes, container, false);

        listaPersonaje=new ArrayList<>();
        recyclerPersonajes= (RecyclerView) vista.findViewById(R.id.recyclerId);
        recyclerPersonajes.setLayoutManager(new LinearLayoutManager(getContext()));

        llenarLista();

        PersonajesAdapter adapter=new PersonajesAdapter(listaPersonaje);
        recyclerPersonajes.setAdapter(adapter);

        return vista;
    }


    private void initListener(){

    }



    private void llenarLista() {
        listaPersonaje.add(new PersonajeVo("Goku","Son Gokū es el protagonista del manga y anime Dragon Ball creado por Akira Toriyama.",R.drawable.goku_cara));
        listaPersonaje.add(new PersonajeVo("Gohan","Son Gohan es un personaje del manga y anime Dragon Ball creado por Akira Toriyama. Es el primer hijo de Son Gokū y Chi-Chi",R.drawable.gohan_cara));
        listaPersonaje.add(new PersonajeVo("Goten","Goten es un personaje ficticio de la serie de manga y anime Dragon Ball. Segundo hijo del protagonista, Goku, y Chichi/Milk.",R.drawable.goten_cara));
        listaPersonaje.add(new PersonajeVo("Krilin","Krilin es un personaje de la serie de manga y anime Dragon Ball. Es el primer rival en artes marciales de Son Gokū aunque luego se convierte en su mejor amigo.",R.drawable.krilin_cara));
        listaPersonaje.add(new PersonajeVo("Picoro","Piccolo es un personaje de ficción de la serie de manga y anime Dragon Ball. Su padre, Piccolo Daimaō, surgió tras separarse de Kamisama. ",R.drawable.picoro_cara));
        listaPersonaje.add(new PersonajeVo("Trunks","Trunks es un personaje de ficción de la serie de manga y anime Dragon Ball de Akira Toriyama. Hijo de Vegueta y Bulma",R.drawable.trunks_cara));
        listaPersonaje.add(new PersonajeVo("Vegueta","Vegeta es un personaje ficticio perteneciente a la raza llamada saiyajin, del manga y anime Dragon Ball.",R.drawable.vegueta_cara));

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }




    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }







    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }


    public interface OnFragmentInteractionListener {
        void itemClick(PersonajeVo item);

        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
