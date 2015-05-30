/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Resources;

import Interfaces.GestorObjetosContrato;
import java.util.Arrays;

/**
 *
 * @author danielteixeira
 */
public class ContainerOfObjects implements GestorObjetosContrato {

    private final int DEFAULT_SIZE = 30;
    private Object[] objects;

    public ContainerOfObjects(Object[] objects) {
        this.objects = objects;

    }

    public ContainerOfObjects() {
        this.objects = new Object[0];
    }

    public ContainerOfObjects(int size) {
        if (size <= DEFAULT_SIZE && size > 0) {
            this.objects = new Object[size];
        }
    }

    public int countObject() {
        int count = 0;
        for (Object obj : this.objects) {
            if (obj != null) {
                count++;
            }
        }
        return count;
    }

    @Override
    public boolean addObject(Object newObject) {
        this.increaseSize();
        this.objects[this.countObject()] = newObject;
        return true;
    }

    @Override
    public Object removeObject(int position) {
        if (countObject() != 0) {
            Object objReturn = this.objects[position];
            for (int i = position; i < countObject(); i++) {
                this.objects[i] = this.objects[i + 1];
            }
            this.decreaseSize();
            return objReturn;
        }
        return null;
    }

    public Object[] getObjects() {
        return objects;
    }

    protected boolean setObject(int position, Object newObject) {
        if (this.objects[position] != null) {
            this.objects[position] = newObject;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Arrays.deepHashCode(this.objects);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ContainerOfObjects other = (ContainerOfObjects) obj;
        if (!Arrays.deepEquals(this.objects, other.objects)) {
            return false;
        }
        return true;
    }

    @Override
    public int findObject(Object obj) {
        int index = -1;
        for (Object object : this.objects) {
            if (object != null) {
                index++;
                if (object.equals(obj) == true) {
                    return index + 1;
                }
            }
        }
        return -1;
    }

//    public void sort(Comparator[] obj) {
//        for (int i = 0; i < objects.length; i++) {
//            for (int j = 0; j < objects.length - i - 1; j++) {
//                if (obj[i].CompareTo(obj[j]) == 1) {
//                    Comparator swap = obj[j];
//                    obj[j] = obj[j + 1];
//                    obj[j + 1] = swap;
//                }
//            }
//        }
//
//    }
    @Override
    public Object getObject(int i) {
        return this.objects[i];
    }

    @Override
    public boolean increaseSize() {
        Object array[] = new Object[this.objects.length + 1];
        System.out.println(array.length);
        System.arraycopy( this.objects, 0, array, 0, this.objects.length );
        this.objects = array;
        return true;
    }

    @Override
    public boolean decreaseSize() {
        Object array[] = new Object[this.objects.length - 1];

        for (int i = 0; i < array.length; i++) {
            array[i] = this.objects[i];
        }
        this.objects = array;
        return true;
    }

    @Override
    public void sort() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
