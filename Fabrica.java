/*
   Integradevs Academy
   
   Proyecto AcademyPaint
   
*/
package academy.paint;

/**
 *  Esta es una interfaz funcional on métodos similares a nuestros objetos figura
 */
@FunctionalInterface
interface Fabrica<A,B,C,D,E, R> {
     public R apply(A a, B b, C c, D d, E e);
}
    