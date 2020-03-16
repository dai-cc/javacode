package com.dai;

class HasStatic{
    private static int x = 100;
    public static void main(String args[ ]){
        HasStatic hs1 = new HasStatic();
        hs1.x++; HasStatic hs2 = new HasStatic();
        hs2.x++;
        hs1=new HasStatic();
        hs1.x++;
        HasStatic.x--;
        System.out.println( "x=" +x);
    }
    Object o = new Object(){public boolean equals(Object obj) { return true; }};
}
