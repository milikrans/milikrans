public class Laberinto {
    private int ren;
    private int col;
    private Array2d mapa;
    private Pila exploradorRen = new Pila<>();
    private Pila exploradorCol = new Pila<>();
    private int finalRen;
    private int finalCol;

    public Laberinto (int ren, int col){
        this.ren = ren;
        this.col = col;
        this.mapa = new Array2d(ren,col);
        this.mapa.clear('■');
    }

    public char getEspacio(int ren, int col){
        return this.mapa.getItem(ren,col);
    }

    public void setPared(int ren, int col){
        this.mapa.setItem(ren,col,'■');
    }

    public void setCamino(int ren, int col){
        this.mapa.setItem(ren,col,'□');
    }

    public void setInicio(int ren, int col){
        this.mapa.setItem(ren,col,'I');
    }

    public void setFinal(int ren, int col){
        this.mapa.setItem(ren,col,'F');
        this.finalRen = ren;
        this.finalCol = col;
    }

    public void imprimirTablero(){
        System.out.println("૮꒰ ˶• ༝ •˶꒱ა ♡⊹ . ݁˖ . ");
        for (int i = 0; i < ren; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(" " + this.mapa.getItem(i,j) + " ");
            }
            System.out.println("");
        }
    }

    public void setExplorador(){
        for (int i = 0; i < ren; i++) {
            for (int j = 0; j < col; j++) {
                if (this.mapa.getItem(i,j)=='I'){
                    this.mapa.setItem(i,j,'o');
                    this.exploradorRen.push(i);
                    this.exploradorCol.push(j);
                }
            }
        }
    }

    public void paso(){
        int expRen = (int)exploradorRen.peek();
        int expCol = (int)exploradorCol.peek();
        if( expCol > 0 && (this.mapa.getItem(expRen,expCol - 1) == '□'|| this.mapa.getItem(expRen,expCol - 1) == 'F')){
            this.mapa.setItem(expRen,expCol - 1, 'o');
            this.exploradorRen.push(expRen);
            this.exploradorCol.push(expCol - 1);
        }else{
            if(expRen > 0 && (this.mapa.getItem(expRen - 1,expCol) == '□' || this.mapa.getItem(expRen - 1,expCol) == 'F')){
                this.mapa.setItem(expRen - 1 ,expCol, 'o');
                this.exploradorRen.push(expRen - 1);
                this.exploradorCol.push(expCol);
            }else{
                if(expCol < this.col && (this.mapa.getItem(expRen,expCol + 1) == '□' || this.mapa.getItem(expRen,expCol + 1) == 'F')){
                    this.mapa.setItem(expRen,expCol + 1, 'o');
                    this.exploradorRen.push(expRen);
                    this.exploradorCol.push(expCol + 1);
                }else{
                    if(expRen < this.ren &&  (this.mapa.getItem(expRen + 1,expCol ) == '□' || this.mapa.getItem(expRen + 1,expCol ) == 'F')) {
                        this.mapa.setItem(expRen + 1, expCol, 'o');
                        this.exploradorRen.push(expRen +1);
                        this.exploradorCol.push(expCol);
                    }else{
                        this.mapa.setItem(expRen,expCol,'x');
                        this.exploradorRen.pop();
                        this.exploradorCol.pop();
                    }
                }
            }
        }



    }

    public int getFinalRen(){
        return this.finalRen;
    }

    public int getFinalCol(){
        return this.finalCol;
    }

    public void resolver(){
        imprimirTablero();
        setExplorador();
        imprimirTablero();
        while (this.mapa.getItem(this.finalRen,this.finalCol) == 'F'){
            paso();
            imprimirTablero();
        }
    }

    @Override
    public String toString() {
        return "Laberinto{" +
                "ren=" + ren +
                ", col=" + col +
                ", mapa=" + mapa +
                '}';
    }
}
