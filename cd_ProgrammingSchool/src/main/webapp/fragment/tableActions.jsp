<div class="form-check-inline">
    <form action="${param.path}/edit" method="post">
        <input type="number" name="id" value="${param.id}" hidden>
        <input type="submit" value="EDIT" class="btn btn-primary">
    </form>
</div>
<div class="form-check-inline">
    <form action="${param.path}/delete" method="post">
        <input type="number" name="id" value="${param.id}" hidden>
        <input type="submit" value="DELETE" class="btn btn-primary">
    </form>
</div>