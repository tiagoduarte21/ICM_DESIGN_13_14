package pt.ua.icm_design_13_14;

import java.util.ArrayList;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Fragment_ProductList extends Fragment {

	private static final String ARG_SECTION_NUMBER = "section_number";
	private ArrayList<Product> products = new ArrayList<Product>();
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		loadListView();
		loadProductList();
		
	}
	
	
	public static Fragment_ProductList newInstance(int sectionNumber) {
		Fragment_ProductList fragment = new Fragment_ProductList();
		Bundle args = new Bundle();
		args.putInt(ARG_SECTION_NUMBER, sectionNumber);
		fragment.setArguments(args);
		return fragment;
	}

	
	

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View v = inflater.inflate(R.layout.fragment_main, container, false);
		ArrayAdapter<Product> adapter = new MyListAdapter();
		ListView listView = (ListView) v.findViewById(R.id.lstViewProducts);
		listView.setAdapter(adapter);
		
		return v;
	}


	
	private void loadListView(){
		
		
		ArrayAdapter<Product> adapter = new MyListAdapter();
	}

	private void loadProductList(){
		products.add(new Product("Produto 1",R.drawable.blueberries,1,10.2f,"Descrição Produto 1"));
		products.add(new Product("Produto 2",R.drawable.carrot,1,10.2f,"Descrição Produto 2"));
		products.add(new Product("Produto 3",R.drawable.coffee_machine,1,10.2f,"Descrição Produto 3"));
		products.add(new Product("Produto 4",R.drawable.toast,1,10.2f,"Descrição Produto 4"));
		products.add(new Product("Produto 5",R.drawable.veinctor_001,1,10.2f,"Descrição Produto 5"));
		products.add(new Product("Produto 6",R.drawable.veinctor_002,1,10.2f,"Descrição Produto 6"));
		products.add(new Product("Produto 7",R.drawable.veinctor_003,1,10.2f,"Descrição Produto 7"));
		products.add(new Product("Produto 8",R.drawable.veinctor_005,1,10.2f,"Descrição Produto 8"));
		
	}
	
	private class MyListAdapter extends ArrayAdapter<Product>{

		public MyListAdapter(){
			super(getActivity(), R.layout.fragment_main, products);
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			
			View itemView = convertView;
			
			LayoutInflater inflater = (LayoutInflater) getContext().getSystemService( Context.LAYOUT_INFLATER_SERVICE );
			
			if (itemView == null) {
				itemView = inflater.inflate(R.layout.item_view, parent, false);
			}
			
			//Find the product to work with
			Product currentProduct = products.get(position);
			
			
			ImageView imageView = (ImageView) itemView.findViewById(R.id.imageView1);
			imageView.setImageResource(currentProduct.getImage());
			
			
			TextView txtPrice = (TextView) itemView.findViewById(R.id.viewPrice);
			txtPrice.setText(Float.toString(currentProduct.getPrice()) + "€");
			
			TextView txtDescription = (TextView) itemView.findViewById(R.id.viewProdDescr);
			txtDescription.setText(currentProduct.getDescription());
			
			TextView txtInst = (TextView) itemView.findViewById(R.id.viewInstitution);
			txtInst.setText(Integer.toString(currentProduct.getInstID()));
			
			TextView txtName = (TextView) itemView.findViewById(R.id.viewProduct);
			txtName.setText(currentProduct.getName());
			
			
			
			//Find the view
			
			
			return itemView;
			//return super.getView(position, convertView, parent);
		}
		
		
		
	}
	
}
