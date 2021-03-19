let editor;

ClassicEditor.create(document.querySelector('.editor'), {
    toolbar: {
      items: [
        'heading',
        '|',
        'bold',
        'italic',
        'link',
        'bulletedList',
        'numberedList',
        'codeBlock',
        'htmlEmbed',
        '|',
        'outdent',
        'indent',
        '|',
        'imageUpload',
        'blockQuote',
        'insertTable',
        'mediaEmbed',
        'undo',
        'redo'
      ]
    },
    language: 'vi',
    image: {
      toolbar: [
        'imageTextAlternative',
        'imageStyle:full',
        'imageStyle:side'
      ]
    },
    table: {
      contentToolbar: [
        'tableColumn',
        'tableRow',
        'mergeTableCells'
      ]
    },
    licenseKey: '',
  })
  .then(editorData => {
    editor = editorData;
  })
  .catch(error => {
    console.error('Oops, something went wrong!');
    console.error('Please, report the following error on https://github.com/ckeditor/ckeditor5/issues with the build id and the error stack trace:');
    console.warn('Build id: roljc925tgl-dp1olaxfjrgr');
    console.error(error);
  });

createNewPost = () => {
  const editorData = editor.getData();
  var form = $('#content-form')[0];
  var formData = new FormData(form);
  formData.append("editor", editorData);
  $.ajax({
    url: 'post-article',
    type: 'POST',
    enctype: 'multipart/form-data',
    processData: false,
    contentType: false,
    cache: false,
    data: formData,
    success: function(result) {
      if (result != null) {
        if (result === "SUCCESS") {
          alert("Post success.");
          location.reload();
        } else if (result === "Category not existed") {
          alert("Category didn't exist.");
        } else if (result === "Template not existed") {
          alert("Template didn't exist.");
        } else {
          alert("Post fail! Try again later.");
        }
      }
    },
    fail: function(xhr, textStatus, errorThrown) {
      alert('Request failed! Post fail! Try again later.');
    }
  })
}
