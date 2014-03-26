package pt.ua.icm_design_13_14;

import java.util.ArrayList;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Fragment_Cities extends Fragment{
	
	private static final String ARG_SECTION_NUMBER = "section_number";
	private ArrayList<City> cities = new ArrayList<City>();
	


	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		loadCitiesList();

	}

	public static Fragment_Cities newInstance(int sectionNumber) {
		Fragment_Cities fragment = new Fragment_Cities();
		Bundle args = new Bundle();
		args.putInt(ARG_SECTION_NUMBER, sectionNumber);
		fragment.setArguments(args);
		return fragment;
	}
	
	
	private void loadCitiesList(){
		
		cities.add(new City("Aveiro",1000));
		cities.add(new City("Porto",2000));
		cities.add(new City("Coimbra",100));
		cities.add(new City("Algarve",500));
		cities.add(new City("Lisboa",300));
		cities.add(new City("Braga",1000));
		cities.add(new City("Guimar�es",900));
		cities.add(new City("Espinho",600));
		cities.add(new City("Matosinhos",400));
		
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View v = inflater.inflate(R.layout.fragment_cities, container, false);

		ArrayAdapter<City> adapter = new MyListAdapter();
		ListView listView = (ListView) v.findViewById(R.id.lstViewCities);
		listView.setAdapter(adapter);
		
		return v;
	}
	
	private class MyListAdapter extends ArrayAdapter<City>{

		public MyListAdapter(){
			super(getActivity(), R.layout.fragment_cities, cities);
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			
			View itemView = convertView;
			
			LayoutInflater inflater = (LayoutInflater) getContext().getSystemService( Context.LAYOUT_INFLATER_SERVICE );
			
			if (itemView == null) {
				itemView = inflater.inflate(R.layout.city_view, parent, false);
			}
			
			//Find the product to work with
			City currentCity = cities.get(position);
			
			
			//ImageView imageView = (ImageView) itemView.findViewById(R.id.imageView1);
			//imageView.setImageResource(currentCity.getName()());
			
			
			TextView txtCityPoints = (TextView) itemView.findViewById(R.id.txtCityPoints);
			txtCityPoints.setText(Integer.toString(currentCity.getPoints()) + " pontos");
			
			TextView txtCityName = (TextView) itemView.findViewById(R.id.txtCityName);
			txtCityName.setText(currentCity.getName());
			
			
			//Find the view
			
			
			return itemView;
			//return super.getView(position, convertView, parent);
		}
		
		
		
	}

}
