package com.mangal.demoserver.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mangal.demoserver.Iterface.ItemClickListener;
import com.mangal.demoserver.R;

public class OrderViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnCreateContextMenuListener {


    public TextView txtOrderId,txtOrderStatus,txtOrderPhone,txtOrderAddress;
   private ItemClickListener itemClickListener;
   /*  After Edit
    public Button btnEdit,btnRemove,btnDetail;*/

    public OrderViewHolder(View itemView) {
        super(itemView);
        txtOrderAddress=(TextView)itemView.findViewById(R.id.order_address);
        txtOrderId=(TextView)itemView.findViewById(R.id.order_id);
        txtOrderStatus=(TextView)itemView.findViewById(R.id.order_status);
        txtOrderPhone=(TextView)itemView.findViewById(R.id.order_phone);

       /*After Edit
       btnEdit=(Button)itemView.findViewById(R.id.btnEdit);
        btnDetail=(Button)itemView.findViewById(R.id.btnDetail);
        btnRemove=(Button)itemView.findViewById(R.id.btnRemove);*/



        itemView.setOnClickListener(this);

       itemView.setOnCreateContextMenuListener(this);

    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
       this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View view) {
        itemClickListener.onClick(view,getAdapterPosition(),false);
        //Toast.makeText(OrderViewHolder.this, "hi!", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {

        contextMenu.setHeaderTitle("Select the Action");
        contextMenu.add(0,0,getAdapterPosition(),"Update");
        contextMenu.add(0,1,getAdapterPosition(),"Delete");

    }

}


