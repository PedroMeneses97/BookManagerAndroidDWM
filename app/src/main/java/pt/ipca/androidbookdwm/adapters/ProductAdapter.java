package pt.ipca.androidbookdwm.adapters;
//Imports
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import pt.ipca.androidbookdwm.R;
import pt.ipca.androidbookdwm.Product;
import pt.ipca.androidbookdwm.interfaces.OnItemResult;

//Classe
public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private List<Product> productList1 = new ArrayList<>(); // Lista de produtos que ainda nao estao no carrinho
    private OnItemResult  onItemResult;

    public ProductAdapter(List<Product> lstProduct, OnItemResult onItemResult)
    {
        this.productList1 = lstProduct;
        this.onItemResult = onItemResult;
    }


    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_item,parent,false);
        return new ProductViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, final int position)
    {

        Product product = productList1.get(position);
        holder.getNomeProd().setText(product.getName());
        holder.getUnidade().setText(product.getUnityType());
        holder.getPreco().setText("" + product.getPrice());
        //holder.getImagemProduto().setImageResource(product.getPicture());
    }

    @Override
    public int getItemCount()
    {
        return productList1 != null ? productList1.size() : 0;
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder
    {

        private ImageView imagemProduto;
        private TextView nomeProd,preco,unidade;
        private CheckBox checkProduct;


        public ProductViewHolder(@NonNull View itemView)
        {
            super(itemView);




            imagemProduto = itemView.findViewById(R.id.iv_ImagemProduto);
            nomeProd = itemView.findViewById(R.id.tv_nomeProduto);
            unidade= itemView.findViewById(R.id.tv_unidade);
            preco = itemView.findViewById(R.id.tv_preco);
            checkProduct = itemView.findViewById(R.id.cb_addProduct);

        }

        public ImageView getImagemProduto() {
            return imagemProduto;
        }

        public void setImagemProduto(ImageView imagemProduto) {
            this.imagemProduto = imagemProduto;
        }

        public TextView getNomeProd() {
            return nomeProd;
        }

        public void setNomeProd(TextView nomeProd) {
            this.nomeProd = nomeProd;
        }

        public TextView getPreco() {
            return preco;
        }

        public void setPreco(TextView preco) {
            this.preco = preco;
        }

        public TextView getUnidade() {
            return unidade;
        }

        public void setUnidade(TextView unidade) {
            this.unidade = unidade;
        }

        public CheckBox getCheckProduct() {
            return checkProduct;
        }

        public void setCheckProduct(CheckBox checkProduct) {
            this.checkProduct = checkProduct;
        }

        //        //GET & E SET DA CLASS public BookViewHolder(@NonNull View itemView) (LINHA 58) (IMEDIATAMENTE ACIMA DESTE COMENTÁRIO)

    }
}
