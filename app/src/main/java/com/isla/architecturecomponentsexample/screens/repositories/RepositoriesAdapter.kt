package com.isla.architecturecomponentsexample.screens.repositories

import android.view.View
import android.widget.TextView
import com.isla.architecturecomponentsexample.R
import com.isla.architecturecomponentsexample.base.BaseAdapter
import com.isla.architecturecomponentsexample.base.BaseViewHolder
import com.isla.architecturecomponentsexample.models_db.Repo

class ReposAdapter : BaseAdapter<Repo, ReposAdapter.ReposViewHolder>() {

    override fun getItemViewId(): Int = R.layout.item_repos

    override fun instantiateViewHolder(view: View?): ReposViewHolder = ReposViewHolder(view)

    class ReposViewHolder(itemView: View?) : BaseViewHolder<Repo>(itemView) {

        val tvName by lazy { itemView?.findViewById<TextView?>(R.id.tvName) }
        val tvDescription by lazy { itemView?.findViewById<TextView?>(R.id.tvDescription) }

        override fun onBind(item: Repo) {
            tvName?.text = item.name
            tvDescription?.text = item.description
        }
    }
}