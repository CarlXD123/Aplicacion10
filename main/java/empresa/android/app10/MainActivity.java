package empresa.android.app10;

import android.net.Uri;
import android.os.Bundle;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import empresa.android.app10.clases.PersonajeVo;
import empresa.android.app10.clases.Utilidades;
import empresa.android.app10.fragments.ContenedorFragment;
import empresa.android.app10.fragments.FormularioFragment;
import empresa.android.app10.fragments.GreenFragment;
import empresa.android.app10.fragments.ListaPersonajesFragment;
import empresa.android.app10.fragments.RedFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        RedFragment.OnFragmentInteractionListener, GreenFragment.OnFragmentInteractionListener,
        FormularioFragment.OnFragmentInteractionListener, ContenedorFragment.OnFragmentInteractionListener,
        ListaPersonajesFragment.OnFragmentInteractionListener{


       EditText campoId,campoNombre,campoTelefono;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();



            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        if (Utilidades.validaPantalla==true){
            Fragment fragment=new FormularioFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.content_main,fragment).commit();
            Utilidades.validaPantalla=false;
        }



        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Fragment miFragment=null;
        boolean fragmentSeleccionado=false;


        if (id == R.id.nav_camera) {
            miFragment=new FormularioFragment();
            fragmentSeleccionado=true;
        } else if (id == R.id.nav_gallery) {
            miFragment=new RedFragment();
            fragmentSeleccionado=true;
        } else if (id == R.id.nav_slideshow) {
            miFragment=new GreenFragment();
            fragmentSeleccionado=true;
        } else if (id == R.id.nav_share) {
            miFragment=new ContenedorFragment();
            fragmentSeleccionado=true;
        } else if (id == R.id.nav_send) {
            miFragment=new ListaPersonajesFragment();
            fragmentSeleccionado=true;
        }

        if (fragmentSeleccionado==true){
            getSupportFragmentManager().beginTransaction().replace(R.id.content_main,miFragment).commit();
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void itemClick(PersonajeVo item) {

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}