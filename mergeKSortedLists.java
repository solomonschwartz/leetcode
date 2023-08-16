import java.util.ArrayList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class mergeKSortedLists {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        // go through each thing and add them to a linked list
        ArrayList<ListNode> main = new ArrayList<>();
        for(int i = 0; i < lists.length; i++){
            ListNode ln = lists[i];
            while(ln != null){
                main.add(ln);
                ln = ln.next;
            }
        }
        if (main.size() == 0){
            return null;
        }
        // make a comparator that compares based on val and a sort ascending
        main.sort((ln1,ln2)->{
            if(ln1.val < ln2.val){
                return -1;
            } else if (ln1.val > ln2.val){
                return 1;
            }
            return 0;
        });

        // then go through list starting from index 1 and setting each next to be the next index until current index is null
        ListNode first = main.get(0);
        for(int i = 0; i < main.size();i++){
            if (i == main.size()-1){
                main.get(i).next = null;
                continue;
            }
            main.get(i).next = main.get(i+1);
        }
        // return first listnode
        return first;
    }
    // we cannot simply make pointers to each array as there might be too many lists
    // we can get each list node
}