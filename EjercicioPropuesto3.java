class EjercicioPropuesto3{
    public static float discriminante(int a,int b,int c){
        float Resultado = (float)((b*b)-(4*a*c))/(2*a);
        return Resultado; 
    }
    public static void main(String[] args){
        int a=1,b=5,c=2;
        System.out.println("El resultado del discriminante es: "+discriminante(a, b, c));
    }
}
