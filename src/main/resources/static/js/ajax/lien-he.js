let editor;
ClassicEditor.create(document.querySelector('.editor'), {
    toolbar: {
      items: [
        'bold',
        'italic',
        '|',
        'bulletedList',
        'numberedList',
        '|',
        'codeBlock',
        '|',
      ]
    },
    language: 'vi',
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
