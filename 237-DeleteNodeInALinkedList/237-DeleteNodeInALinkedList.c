// Last updated: 08/10/2025, 06:08:08
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
void deleteNode(struct ListNode* node) {
    struct ListNode* temp = node->next;
    node->next = temp->next;
    node->val = temp->val;
    free(temp);
}