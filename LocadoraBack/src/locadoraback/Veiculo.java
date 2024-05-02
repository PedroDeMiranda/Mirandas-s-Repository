package locadoraback;

public class Veiculo {

    private int     codVeiculo;
    private String  marcaVeiculo;
    private String  modeloVeiculo;
    private String  placaVeiculo;
    private boolean locado;

    public Veiculo(int codVeiculo, String marcaVeiculo, String modeloVeiculo, String placaVeiculo, boolean locado) {
        this.codVeiculo = codVeiculo;
        this.marcaVeiculo = marcaVeiculo;
        this.modeloVeiculo = modeloVeiculo;
        this.placaVeiculo = placaVeiculo;
        this.locado = locado;
    }

    Veiculo() {

    }

   

    public boolean abastecer(String tipoCombustivel, 
                             int    qtdCombustivel, 
                             float  precoCombustivel){
        return true;
    }
    
    @Override
    public String toString() {
        return "codVeiculo= " + codVeiculo 
             + " marcaVeiculo=" + marcaVeiculo 
             + " modeloVeiculo=" + modeloVeiculo 
             + " placaVeiculo=" + placaVeiculo 
             + " locado=" + locado + '}';
    }

// area de getters e setters
    public int getCodVeiculo() {
        return codVeiculo;
    }

    public void setCodVeiculo(int codVeiculo) {
        this.codVeiculo = codVeiculo;
    }

    public String getMarcaVeiculo() {
        return marcaVeiculo;
    }

    public void setMarcaVeiculo(String marcaVeiculo) {
        this.marcaVeiculo = marcaVeiculo;
    }

    public String getModeloVeiculo() {
        return modeloVeiculo;
    }

    public void setModeloVeiculo(String modeloVeiculo) {
        this.modeloVeiculo = modeloVeiculo;
    }

    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    public void setPlacaVeiculo(String placaVeiculo) {
        this.placaVeiculo = placaVeiculo;
    }

    public boolean isLocado() {
        return locado;
    }

    public void setLocado(boolean locado) {
        this.locado = locado;
    }
    
}
