// Call the dataTables jQuery plugin
$(document).ready(function() {
    $('#inbond').DataTable( {
        dom: 'Bfrtip',
        scrollX: 10,
        scrollCollapse: true,
        scroller:       true,
        buttons: [
            'copy', 'excel', 'pdf'
        ]
//        select: {
//          style: 'multi'
//        }
    } );
} );
