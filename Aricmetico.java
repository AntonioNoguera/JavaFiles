class Aricmetico{
    public static void main(String[] args){
        int A=1, B=5, C=16,Resultado;
        
        //En el caso de Suma
        Resultado = A+B+C;
        System.out.println("La suma de los digitos "+A+" + "+B+" + "+C+" = "+Resultado);

        //En el Caso de Resta
        Resultado = A-B-C;
        System.out.println("La resta de los dígitos "+A+" - "+B+" - "+C+" = "+Resultado);

        //En el Caso de Multiplicación
        Resultado = A*B*C;
        System.out.println("La multiplicación de "+A+" × "+B+" × "+C+" = "+Resultado);
        
        //En caso de División
        float Resultdo = A/B/C;
        System.out.println("La división es igual a: "+A+" / "+B+" / "+C+" = "+Resultdo);
    }

}