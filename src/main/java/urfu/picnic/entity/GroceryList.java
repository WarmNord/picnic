package urfu.picnic.entity;

import javax.persistence.*;


@Entity
@Table(name = "list")
public class GroceryList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int listId;

    @Column(length = 50, nullable = false)
    private String listName;

    @Column(length = 50, nullable = false)
    private String productName;

    @Column(nullable = false)
    private int categoryId;

    private Integer weight;

    private Integer liters;

    private Integer quantity;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "categoryId", nullable = false)
    private Category category;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "listId")
    private UserLists userLists;
}
