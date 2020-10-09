import { mount } from '@vue/test-utils'
import TopMenu from "../TopMenu.vue";

test('basic', () => {
    const wrapper = mount(TopMenu, {
        propsData: {
            links: []
        }
    })

    expect(wrapper.findAll('.topnav a')).toHaveLength(0)
})
