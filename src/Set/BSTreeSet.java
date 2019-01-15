package Set;

import BSTree.BSTree;

public class BSTreeSet<E extends Comparable<E>> implements Set<E> {

    private BSTree<E> tree;

    public BSTreeSet(){

        tree = new BSTree<E>();
    }

    @Override
    public void add(E e) {

        tree.add(e);
    }

    @Override
    public void remove(E e) {
        tree.remove(e);
    }

    @Override
    public boolean contains(E e) {

        return tree.contains(e);
    }

    @Override
    public int getSize() {

        return tree.getSize();
    }

    @Override
    public boolean isEmpty() {

        return tree.isEmpty();
    }
}
