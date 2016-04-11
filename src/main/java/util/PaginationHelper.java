package util;

/* baseado nessa url
    http://www.oracle.com/webfolder/technetwork/tutorials/obe/java/JSFTablePagination/JSFTablePagination.html
    by marcus2vinicius
*/

public class PaginationHelper {

    private int pageSize;
    private int page;
    private int total;

    public PaginationHelper(int pageSize, int total) {
        this.pageSize = pageSize;
        this.total = total;
    }

    public int getCurrentPage(){
        return page;
    }

    public int getItemsCount(){
        return total;
    }

    public int getPageFirstItem() {
        return page * pageSize;
    }

    public int getPageLastItem() {
        int i = getPageFirstItem() + pageSize - 1;
        int count = getItemsCount() - 1;
        if (i > count) {
            i = count;
        }
        if (i < 0) {
            i = 0;
        }
        return i;
    }

    public boolean isHasNextPage() {
        return (page + 1) * pageSize + 1 <= getItemsCount();
    }

    public int nextPage() {
        if (isHasNextPage()) {
            return page++;
        }
        return page;
    }

    public boolean isHasPreviousPage() {
        return page > 0;
    }

    public int previousPage() {
        if (isHasPreviousPage()) {
            return page--;
        }
        return page;
    }

    public int getPageSize() {
        return pageSize;
    }
}
