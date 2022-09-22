$('#FonctionLangue').on('change', function() {
    $('option:selected', this).attr('selected',true).siblings().removeAttr('selected');
});