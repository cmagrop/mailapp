package com.example.mailapp.adapters;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.mailapp.R;
import com.example.mailapp.models.Mail;

import java.util.List;

public class MailAdapter extends BaseAdapter{
    private Context context;
    private int layout;
    private List<Mail> list;
    final private int SUBJECT_MAX_LENGHT = 40;
    final private int MESSAGE_MAX_LENGHT = 80;

    public MailAdapter(Context context, int layout, List<Mail> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
    }


    @Override
    public int getCount() {
        return list.size();

    }

    @Override
    public Mail getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

       ViewHolder holder; //recipiente de la vista
        if(convertView==null)
        {
            convertView = LayoutInflater.from(context).inflate(layout,null);
            holder = new ViewHolder();
            holder.subject = convertView.findViewById(R.id.textViewListSubject);
            holder.message = convertView.findViewById(R.id.textViewListMessage);
            holder.sender =  convertView.findViewById(R.id.textViewListSenderName);
            convertView.setTag(holder);

        }
        else
        {
            holder = (ViewHolder) convertView.getTag();
        }


        Mail currentMail = getItem(position);
        String shortSubject;
        /*si el subject (asunto) tiene mayor cantidad de caracteres que SUBJECT_MAX_LENGHT,
        entonces acortará el String , en caso contrario lo dejará igual

         */
        if(currentMail.getSubject().length()>SUBJECT_MAX_LENGHT)
        {
            shortSubject = currentMail.getSubject().substring(0,SUBJECT_MAX_LENGHT);

        }
        else
        {
            shortSubject= currentMail.getSubject();
        }
        holder.subject.setText(shortSubject); //establece el texto del subject en el holder

        //ahora haremos lo mismo con el message
        String shortMessage;
        if(currentMail.getMessage().length()>MESSAGE_MAX_LENGHT)
        {
            shortMessage = currentMail.getMessage().substring(0,MESSAGE_MAX_LENGHT);

        }
        else
        {
            shortMessage = currentMail.getMessage();

        }

        holder.message.setText(shortMessage);

        holder.sender.setText(currentMail.getSenderName().substring(0,1));
        holder.sender.getBackground().setColorFilter
                (Color.parseColor("#"+currentMail.getColor()), PorterDuff.Mode.SRC);

        return convertView;
    }
    class ViewHolder
    {
        private TextView subject;
        private TextView message;
        private TextView sender;

    }
}
